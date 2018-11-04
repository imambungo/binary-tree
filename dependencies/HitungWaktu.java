package dependencies;

public class HitungWaktu {
    private long startTime;
    private long endTime;
    private long runTime;
    private String namaProgram;

    public HitungWaktu() {
    }

    public HitungWaktu(String namaProgram) {
        this.namaProgram = namaProgram;
    }

    public void startTime() {
        startTime = System.nanoTime();
        // System.out.println("startTime : "+startTime);
    }

    public void endTime() {
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        // System.out.println("endTime : " + endTime);
    }

    public void runTime() {
        if (this.namaProgram == null)
            System.out.println("runTime\t\t: " + runTime + " ns");
        else
            System.out.println(this.namaProgram + "\nrunTime\t\t: " + runTime + " ns\n");
    }

    public void startTimeM() {
        startTime = System.currentTimeMillis();
        // System.out.println("startTime : "+startTime);
    }

    public void endTimeM() {
        endTime = System.currentTimeMillis();
        runTime = endTime - startTime;
        // System.out.println("endTime : " + endTime);
    }

    public void runTimeM() {
        if (this.namaProgram == null)
            System.out.println("runTime\t\t: " + runTime + " ms");
        else
            System.out.println(this.namaProgram + "\nrunTime\t\t: " + runTime + " ms\n");
    }

    public long getRunTime() {
        return runTime;
    }

}