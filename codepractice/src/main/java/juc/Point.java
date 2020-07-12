package juc;

import java.util.concurrent.locks.StampedLock;

class Point {
    private double x, y;
    private final StampedLock sl = new StampedLock();

    void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();    //�漰�Թ�����Դ���޸ģ�ʹ��д��-��ռ����
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    /**
     * ʹ���ֹ۶������ʹ�����Դ
     * ע�⣺�ֹ۶����ڱ�֤����һ��������Ҫ����һ��Ҫ�����ı���������ջ�������ڲ�������ʱ���������д�߳��Ѿ��޸������ݣ�
     * �����ǲ������Ƿ���ջ��������ݣ�Ҳ����һ�����գ�������෵�صĲ������µ����ݣ�����һ���Ի��ǵõ����ϵġ�
     *
     * @return
     */
    double distanceFromOrigin() {
        long stamp = sl.tryOptimisticRead();    // ʹ���ֹ۶���
        double currentX = x, currentY = y;      // ����������Դ�����ط���ջ��
        if (!sl.validate(stamp)) {              // �����д����ռ�ã�����������ݲ�һ�£�����Ҫ�л�����ͨ����ģʽ
            stamp = sl.readLock();             
            try {
                currentX = x;
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    void moveIfAtOrigin(double newX, double newY) { // upgrade
        // Could instead start with optimistic, not read mode
        long stamp = sl.readLock();
        try {
            while (x == 0.0 && y == 0.0) {
                long ws = sl.tryConvertToWriteLock(stamp);  //����ת��Ϊд��
                if (ws != 0L) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }
}