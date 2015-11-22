package uno;

public class CurrentPlayer{
        private int player = 0;
        private int totalPlayers;
        private int currentDirection = 1;
        public CurrentPlayer(int IMPtotalPlayers){
                totalPlayers = IMPtotalPlayers;
        }
        public int getCurrentPlayer(){
                return player;
        }
        public void nextPlayer(){
                player = player + currentDirection;
                if(player >= totalPlayers){
                        player = player - totalPlayers;
                }
                if(player < 0){
                        player = player + totalPlayers;
                }
        }
        public void switchDirections(){
                currentDirection = currentDirection * -1;
        }
}