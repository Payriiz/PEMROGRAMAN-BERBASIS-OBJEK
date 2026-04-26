public class MahasiswaKu <Nim, Name, Clas>{
        private Nim nim;
        private Name name;
        private Clas clas;

        // Setter
        public void setNim (Nim nim) {
            this.nim = nim;
        }
        public void setName (Name name) {
            this.name = name;
        }
        public void setClas (Clas clas) {
            this.clas = clas;
        }

        // Geter
        public Nim getNim() {
            return nim;
        }
        public Name getName() {
            return name;
        }
        public Clas getClas() {
            return clas;
        }
}
