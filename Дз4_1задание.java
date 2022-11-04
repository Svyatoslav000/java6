
class Main
{
	enum VremenaGoda{//перечисление
        Зима(-15){
            public void Info(){
               System.out.println("Зима — время холодов и слякоти");
            }
        },
        Весна(13){
            public void Info(){
               System.out.println("Весна — все тает");
            }
        },
        Лето(26){
            public void getDescription() {
                System.out.println("Жаркое время года");
            }
            public void Info(){
               System.out.println("Ле́то — наконец-то тепло, но кусают комары");
            }
        },
        Осень(6){
            public void Info(){
               System.out.println("Осень — время дождей");
            }
        };

        private double sredT;

        VremenaGoda(double sredT) {
            this.sredT = sredT;
        }//средняя температура

        public void getDescription() {
            System.out.println("Холодное время года");
        }//теплое или холодное время года
        
        public double dobavitT(double sredT) {//добавление температуры
            this.sredT = sredT;
            return sredT;
        }
        public double SrednT() {return sredT;}

        public void Info() {
        }
    }
	
	public static void main(String[] args) {
		VremenaGoda lub = VremenaGoda.Лето ;
        System.out.println("Любимое время года:");
        Vivod(lub);
        Love(lub);
        System.out.println();
        System.out.println("Все времена года:");
        VremenaGoda[] vrg= {VremenaGoda.Зима, VremenaGoda.Весна, VremenaGoda.Лето, VremenaGoda.Осень};//массив сезонов для вывода
        for (VremenaGoda s: vrg){
            Vivod(s);
        }
        System.out.println("Меняем температуру любимого времени года на "+ lub.dobavitT(5));
	}

    public static void Vivod(VremenaGoda season){//вывод в нижеуказанном формате
        season.Info();
        season.getDescription();
        System.out.println(season.SrednT());
    }


	public static void Love(VremenaGoda season){//выводит любимый сезон
	    switch(season){
            case Весна: 
                System.out.println("Я люблю весну");
                break;
            case Лето: 
                System.out.println("Я люблю лето");
                break;
            case Осень: 
                System.out.println("Я люблю осень");
                break;
            case Зима: 
                System.out.println("Я люблю зиму");
                break;
        }
	}
}
