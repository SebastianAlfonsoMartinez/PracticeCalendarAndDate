import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class Main {
    public static void main(String[] args) {

        //Completa los pasos 1 - 5 para aprender a manejar las fechas en Java.

    /*
      1. Modifica el siguiente código para que la variable birthDate tenga los datos exactos           de tu fecha de nacimiento
    */

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 04);
        calendar.set(Calendar.YEAR, 1994);
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 15);
        calendar.set(Calendar.MILLISECOND, 10);
        Date birthDate = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE dd/MMM/yyyy HH:mm:ss");
        System.out.println("Fecha de nacimiento: "+simpleDateFormat.format(birthDate));

    /*
      2. quita los comentarios de las líneas 20, 21 y 22 para restar 365 días a tu fecha de
       nacimiento para ver que día de la semana era hace 1 año
    */
        calendar.add(Calendar.DAY_OF_YEAR, -365);
        Date oneYearBeforeBirthdate = calendar.getTime();
        System.out.println("Fecha de un anio antes de nacimiento: "+simpleDateFormat.format(oneYearBeforeBirthdate));
        //se suma nuevamente el anio restado
        calendar.add(Calendar.DAY_OF_YEAR, 365);
    /*
      3. quita los comentarios de las líneas 27, 28 y 29 para sumar 365 días a tu fecha de
       nacimiento para ver que día de la semana fué después 1 año
    */
        calendar.add(Calendar.DAY_OF_YEAR, 365);
        Date oneYearAfterBirthdate = calendar.getTime();
        System.out.println("Fecha un anio despues del nacimiento: " + simpleDateFormat.format(oneYearAfterBirthdate));
        //se resta nuevamente el anio sumado
        calendar.add(Calendar.DAY_OF_YEAR, -365);


    /*
      4. Crea una segunda instancia de la clase Calendar y asignale la fecha de nacimiento de          alguien de tu familia.
      5. Calcula los días, meses, horas de diferencia entre tu nacimiento y el de tu familiar
    */

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.MONTH, Calendar.JANUARY);
        calendar1.set(Calendar.DAY_OF_MONTH, 01);
        calendar1.set(Calendar.YEAR, 1995);
        calendar1.set(Calendar.HOUR_OF_DAY, 00);
        calendar1.set(Calendar.MINUTE, 00);
        calendar1.set(Calendar.SECOND, 05);
        calendar1.set(Calendar.MILLISECOND, 15);
        Date birthDate1 = calendar1.getTime();
        System.out.println("Fecha de naciemiento familiar: " + simpleDateFormat.format(birthDate1));

        long diferenciaEnMilisegundos = Math.abs(calendar.getTimeInMillis() - calendar1.getTimeInMillis());
        long diffYear = calendar.get(Calendar.YEAR) - calendar1.get(Calendar.YEAR);
        long diffMonth = calendar.get(Calendar.MONTH) - calendar1.get(Calendar.MONTH);
        long months = Math.abs(diffYear * 12 + diffMonth);
        long days = TimeUnit.MILLISECONDS.toDays(diferenciaEnMilisegundos);
        long hours = TimeUnit.MILLISECONDS.toHours(diferenciaEnMilisegundos);

        System.out.println("Meses de diferencia entre fechas: " + calendar.getTime() + " y " +calendar1.getTime() + " = " + months);
        System.out.println("Dias de diferencia entre fechas: " + calendar.getTime()  + " y " +calendar1.getTime() + " = " + days);
        System.out.println("Horas de diferencia entre fechas: " + calendar.getTime()  + " y " +calendar1.getTime() + " = " + hours);
    }
}