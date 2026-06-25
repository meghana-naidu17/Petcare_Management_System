public class ActivitySelection {

    public static void selectAppointments() {

        int[] start =
                {1, 3, 0, 5, 8, 5};

        int[] finish =
                {2, 4, 6, 7, 9, 9};

        System.out.println(
                "\nSelected Appointments:");

        int i = 0;

        System.out.println(
                "Appointment "
                        + (i + 1));

        for(int j = 1;
            j < finish.length;
            j++) {

            if(start[j]
                    >=
               finish[i]) {

                System.out.println(
                        "Appointment "
                                + (j + 1));

                i = j;
            }
        }
    }
}