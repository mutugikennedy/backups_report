package com.backup.reports.util;

import java.io.File;

public class DiskSpace {

    private File file;

    public DiskSpace() {
        this.file = new File("D:\\");
    }

    public long totalDiskSpace(){

        return this.file.getTotalSpace();
    }

    public long totalRemainSpace(){

        return this.file.getUsableSpace();
    }

    public long  usedDiskSpace(){

        return (totalDiskSpace() - totalRemainSpace());
    }

    public double diskUsage(){

        return usedDiskSpace()/totalDiskSpace();

    }
}
