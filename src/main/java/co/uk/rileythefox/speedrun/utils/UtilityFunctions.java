package co.uk.rileythefox.speedrun.utils;

import java.io.File;

public class UtilityFunctions {

    public static void deleteFolder(File dir, boolean removeDirectory) {
        File[] files = dir.listFiles();

        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                deleteFolder(file, removeDirectory);
            }
            file.delete();
        }

        if (removeDirectory)
            dir.delete();
    }

    public static void deleteWorld(File world) {
        File[] files = world.listFiles();

        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                deleteFolder(file, false);
            }
            if (file.getName().equals("uid.dat"))
                continue;

            file.delete();
        }
    }

}
