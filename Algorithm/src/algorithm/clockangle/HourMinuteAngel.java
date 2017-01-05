/*
 * The idea is to take 12:00 (h = 12, m = 0) as a reference. Following are detailed steps.
 * 1) Calculate the angle made by hour hand with respect to 12:00 in h hours and m minutes.
 * 2) Calculate the angle made by minute hand with respect to 12:00 in h hours and m minutes.
 * 3) The difference between two angles is the angle between two hands.
 * How to calculate the two angles with respect to 12:00? 
 * The minute hand moves 360 degree in 60 minute(or 6 degree in one minute) and 
 * hour hand moves 360 degree in 12 hours(or 0.5 degree in 1 minute). In h hours and m minutes, 
 * the minute hand would move (h*60 + m)*6 and hour hand would move (h*60 + m)*0.5.
 */
package algorithm.clockangle;

/**
 *
 * @author Tesfay
 */

public class HourMinuteAngel {
private int min(int x, int y) { return (x < y) ? x : y; }

public int hourAndMinuteAngle(double h , double m){
    if( h < 0 || m < 0 || h > 12 || m > 60) throw new IllegalArgumentException("Wrong Input");
    
    if(h == 12 ) h = 0 ;
    if(m == 60) m = 0 ;
    
    int hour_angle = (int) (0.5*(h*60+m));  //(360/12*60)*(h*60 + m);
    int minute_angle =  (int) (6*m);       //(360/60)*(m);
    
    int angle = Math.abs(hour_angle - minute_angle);
    
    return min(360 - angle, angle);    
}
}
