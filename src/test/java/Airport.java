public class Airport {
        private int countOfAirplane;
        private int countOfStaff;
        private String address;
        private String directions;
        private String status;

        public Airport(int countOfAirplane,int countOfStaff,String address,String directions,String status){
            this.countOfAirplane= countOfAirplane;
            this.countOfStaff= countOfStaff;
            this.address=address;
            this.directions=directions;
            this.status=status;
        }

        public int getCountOfAirplane() {
            return countOfAirplane;
        }

        public int getCountOfStaff() {
            return countOfStaff;
        }

        public String getAddress() {
            return address;
        }

        public String getDirections() {
            return directions;
        }

        public String getStatus() {
            return status;
        }
    }


