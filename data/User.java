package cryjin.archeryapp.data;

/**
 * Created by chaelimseo on 1/26/17.
 */

import java.util.Random;

/**
 * Archery AI application
 #Keep track of the user's skill level and give a close match
 #Match => Set => Arrow

 #Database of users? to be implemented later
 */

//Class to store user information - average arrow value, age


public class User {

    Random rand;

    public String userName;
    public String email;
    public int avg_arrow_value;
    public int total_num_arrows;
    public int total_arrow_score;

    public User(){

    }

    //when signing up
    public User(String userName, String email){
        this.userName = userName;
        this.email = email;
    }

    public User(String name){

        avg_arrow_value = 0;
        total_num_arrows = 0;
        total_arrow_score = 0;
    }

    public String getName(){
        return userName;
    }

    public int getAvg_arrow_value() {
        return avg_arrow_value;
    }

    public void update_arrow_count(int number) {

        this.total_num_arrows += number;
    }

    public void update_arrow_score(int number) {

        this.total_arrow_score += number;
    }

    public void update_avg() {

        this.avg_arrow_value = this.total_arrow_score / this.total_num_arrows;
    }

    public User checkUser(){

        User user = new User("Kevin");

        return user;

        /**
         * if user exists in database... for now proceed with building a new user
         if user.get_name() in all_users:
         user = all_users[user.get_name()]
         else:
         all_users[user.get_name()] = user
         */
    }

    /**
     * take in the user typed numbers
     * @return
     */
    public int[] user_arrows(){

        int[] arrows = new int[3];

        return arrows;
    }

    public int[] com_arrows(User user){

        return generate_arrow_vals(user);
    }

    public int[] generate_arrow_vals(User user){

        //return a list of 3 integers near the user's average
        int threeMatch = 3;
        int threshold = 10;
        int set_avg = user.getAvg_arrow_value() * threeMatch;
        int[] ans = new int[threeMatch];

        for (int i=0; i<threeMatch; i++){
            int c = set_avg/threeMatch + rand.nextInt(((threeMatch-1) - (-1)) + 1 ) - 1;

            if( c > threshold)
                c = threshold;

            if (c < 0)
                c = 0;

            ans[i] = c;
        }

        return ans;
    }

    public int sum(int[] array){

        return (array[0] + array[1] + array[2]);
    }


    public void elim_match(){

        User user = checkUser();

        //5:5 case - tiebreaker with one arrow shootoff
        //3 cases - win, lose, tie

        int num_arrows = 0;
        int num_score = 0;
        int com_score = 0;
        int user_score = 0;

        int set_user_score = sum(user_arrows());
        int set_com_score = sum(com_arrows(user));

        while(com_score<6 && user_score<6){

            //generate a random list of numbers that average to the user_score average +/- 1 pending difficulty

            if ( set_user_score > set_com_score){
                user_score += 2;
                //print out the result
            }

            else if (set_user_score < set_com_score){
                com_score += 2;
                //print out the result
            }

            else{
                user_score += 1;
                com_score += 1;
                //print out the result
            }

            num_arrows += 3;
            num_score += set_user_score;

//            if (user_score == 5 & com_score == 5){
//                System.out.println("one arrow shoot off");
//
//
//                 //generate an arrow value
//                 double comp_arrow = avg_arrow_value + 0.3; //modify to make this more random, capped at 10 - decimal values for approximate distance to center
//                 double user_arrow = input("Your arrow value:")
//
//                 num_arrows += 1;
//                 num_score += user_arrow;
//
//                 if (comp_arrow > user_arrow)
//                    System.out.print("You lose.");
//                 else if (comp_arrow < user_arrow)
//                    System.out.print("You win.");
//            }

            user.update_arrow_count(num_arrows);
            user.update_arrow_score(num_score);
            user.update_avg();

        }

    }
}
