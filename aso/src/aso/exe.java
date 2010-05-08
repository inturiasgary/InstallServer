import java.io.*;

public class exe
{
    public static void ejecutar(String comando)
    {
        String comandos= comando + " > exe";
        try
        {
            String[] command = {"sh","-c",comandos};
            final Process process = Runtime.getRuntime().exec(command);
            new Thread()
            {
                public void run()
                {
                    try
                    {
                        InputStream is = process.getErrorStream();
                        byte[] buffer = new byte[1024];
                        for(int count = 0; (count = is.read(buffer)) >= 0;)
                        {
                            System.err.write(buffer, 0, count);
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }.start();

            int returnCode = process.waitFor();
            System.out.println("Return code = " + returnCode);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static String[] cargar(String eje){
		String[] arr=new String[3];
		String tres="",dos="";
		int con=0;
		for(int i=0;i<=eje.length()-1;i++){
			dos=eje.substring(i,i+1);
			tres=tres+dos;
			if(dos.equals(" ")){
				arr[con]=tres;
				con=con+1;
				tres="";
			}
		}
		arr[con]=tres;
    	return arr;
    }
    public static int contar(String eje){
    	String dos="";
		int con=0;
		for(int i=0;i<=eje.length()-1;i++){
			dos=eje.substring(i,i+1);
			if(dos.equals(" "))
				con=con+1;
		}
		return con+1;
    }
    public static void eliminar(String comando){
        File fichero = new File(comando);
        if (fichero.delete())
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        else
            System.out.println("El fichero no puede ser borrado");
    }
    public static void renombrar(String file1,String file2){
        File f1 = new File(file1);
        File f2 = new File(file2);
        if (f1.renameTo(f2))
            System.out.println("El renombrado ha sido correcto");
        else
            System.out.println("El renombrado no se ha podido realizar");
    }
}