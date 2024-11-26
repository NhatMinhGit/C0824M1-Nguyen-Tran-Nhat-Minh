
public class TennisGame {
    public static String loveAll = "Love-All";
    public static String fifteenAll = "Fifteen-All";
    public static String thirtyAll = "Thirty-All";
    public static String fortyAll = "Forty-All";
    public static String deuce = "Deuce";

    public static String love = "Love";
    public static String fifteen = "Fifteen";
    public static String thirty = "Thirty";
    public static String forty = "Forty";
    public static String advantageP1 = "Advantage player1";
    public static String advantageP2 = "Advantage player2";
    public static String win4P1 = "Win for player1";
    public static String win4P2 = "Win for player2";

    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        String score = "";
        int tempScore=0;
        if (m_score1==m_score2)
        {
            switch (m_score1)
            {
                case 0:
                    score = loveAll;
                    break;
                case 1:
                    
                    score = fifteenAll;
                    break;
                case 2:
                    
                    score = thirtyAll;
                    break;
                case 3:
                    
                    score = fortyAll;
                    break;
                default:
                    score = deuce;
                    break;

            }
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int scoreGap = m_score1 - m_score2;
            int minusResult = scoreGap;
            if (minusResult==1) {
                score = advantageP1;
            } else if (minusResult ==-1) {
                score = advantageP2;
            }
            else if (minusResult>=2) {

                score = win4P1;
            } else {
                score = win4P2;
            }
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = m_score1;
                else {
                    score+="-";
                    tempScore = m_score2;
                }
                switch(tempScore)
                {
                    case 0:
                        score+= love;
                        break;
                    case 1:
                        score+= fifteen;
                        break;
                    case 2:
                        score+= thirty;
                        break;
                    case 3:
                        score+= forty;
                        break;
                }
            }
        }
        return score;
    }
}