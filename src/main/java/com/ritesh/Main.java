

package com.ritesh;

import com.ritesh.hospital.database.ui.LoginFrame;
import com.ritesh.hospital.database.DatabaseInitializer;

public class Main {

    public static void main(String[] args) {
        DatabaseInitializer.initializeDatabase();

        new LoginFrame();

    }
}