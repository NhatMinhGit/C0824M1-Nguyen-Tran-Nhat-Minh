public class StopWatch {
    private long startTime;
    private long endTime;

    // Phương thức khởi tạo
    public StopWatch() {
        startTime = System.currentTimeMillis();
    }

    // Phương thức start() để đặt lại startTime
    public void start() {
        startTime = System.currentTimeMillis();
    }

    // Phương thức stop() để ghi lại endTime
    public void stop() {
        endTime = System.currentTimeMillis();
    }

    // Phương thức trả về thời gian đã trôi qua
    public long getElapsedTime() {
        return endTime - startTime;
    }

    // Getter cho startTime
    public long getStartTime() {
        return startTime;
    }

    // Getter cho endTime
    public long getEndTime() {
        return endTime;
    }
}
