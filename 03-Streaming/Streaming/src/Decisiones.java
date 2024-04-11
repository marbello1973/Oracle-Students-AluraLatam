public class Decisiones {
    public static void main(String[] args) {

        int fechaDeLanzamiento = 1999;
        boolean incluyeEnPlan = false;
        double notaDeLaPelicula = 8.2;
        String tipoPlan = "plus";

        if(fechaDeLanzamiento >= 2022){
            System.out.println("Peliculas mas populares");
        }else{
            System.out.println("Peliculas retro que vale la pena ver");
        }

        if(incluyeEnPlan && tipoPlan.equals("plus")){
            System.out.println("Puede disfrutrar de la pelicula");
        }else{
            System.out.println("Pelicula no disponible para su plan actual");
        }
    }
}
