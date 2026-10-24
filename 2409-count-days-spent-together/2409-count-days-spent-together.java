
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String commonStart = "";
        String commonEnd = "";

        int count = 0;

        String aliceStartMonth = arriveAlice.charAt(0) + "" + arriveAlice.charAt(1) + "";
        String bobStartMonth = arriveBob.charAt(0) + "" + arriveBob.charAt(1) + "";

        if (!aliceStartMonth.equals(bobStartMonth)) {
            if (Integer.parseInt(aliceStartMonth) > Integer.parseInt(bobStartMonth)) {
                commonStart = arriveAlice;
            } else {
                commonStart = arriveBob;
            }
        } else {
            String aliceStartDay = arriveAlice.charAt(3) + "" + arriveAlice.charAt(4) + "";
            String bobStartDay = arriveBob.charAt(3) + "" + arriveBob.charAt(4) + "";

            if (Integer.parseInt(aliceStartDay) > Integer.parseInt(bobStartDay)) {
                commonStart = arriveAlice;
            } else {
                commonStart = arriveBob;
            }
        }

        String aliceEndMonth = leaveAlice.charAt(0) + "" + leaveAlice.charAt(1) + "";
        String bobEndMonth = leaveBob.charAt(0) + "" + leaveBob.charAt(1) + "";

        if (!aliceEndMonth.equals(bobEndMonth)) {
            if (Integer.parseInt(aliceEndMonth) < Integer.parseInt(bobEndMonth)) {
                commonEnd = leaveAlice;
            } else {
                commonEnd = leaveBob;
            }
        } else {
            String aliceEndDay = leaveAlice.charAt(3) + "" + leaveAlice.charAt(4) + "";
            String bobEndDay = leaveBob.charAt(3) + "" + leaveBob.charAt(4) + "";

            if (Integer.parseInt(aliceEndDay) < Integer.parseInt(bobEndDay)) {
                commonEnd = leaveAlice;
            } else {
                commonEnd = leaveBob;
            }
        }

        System.out.println("commonStart = " + commonStart);
        System.out.println("commonEnd = " + commonEnd);

        if (commonStart.compareTo(commonEnd) > 0) {
            return 0;
        }

        String monthStart = commonStart.charAt(0) + "" + commonStart.charAt(1);
        String monthEnd = commonEnd.charAt(0) + "" + commonEnd.charAt(1);

        if (!monthStart.equals(monthEnd)) {
            int monthStartdate = Integer.parseInt(monthStart);
            int monthEnddate = Integer.parseInt(monthEnd);

            int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            for (int month = monthStartdate; month < monthEnddate; month++) {
                count += daysInMonth[month - 1];  
            }
        }

        String dayStart = commonStart.charAt(3) + "" + commonStart.charAt(4) + "";
        String dayEnd = commonEnd.charAt(3) + "" + commonEnd.charAt(4) + "";

        int dayStartdate = Integer.parseInt(dayStart);
        int dayEnddate = Integer.parseInt(dayEnd);

        if (monthStart.equals(monthEnd)) {
            count = dayEnddate - dayStartdate + 1; 
        } else {
            count = count - dayStartdate + dayEnddate + 1; 
        }

        return count; 
    }
}
