//ejecutar
import java.awt.*;     // modo grafico
import java.io.*;      // entrada/salida
import javax.swing.JTextField;

public class terminal extends Frame {

 static Button ejecutar = new Button("Ejecutar");
 static Button cerrar = new Button("Cerrar");
 static TextArea texto = new TextArea(35,100);
 public static JTextField mensaje = new JTextField(40);
 static File nombre;
 static Font fuente;
 static File archivo;
 static String mensa = "";
 public static void main( String args[]) {
     new terminal();
     activar();
     texto.append("Consola Iniciada...\n");
 }

 public terminal() {

     setTitle("Gnome-Consola/karmic koala 9.10");

     fuente = new Font("Currier", Font.ROMAN_BASELINE + Font.BOLD, 15);
     texto.setFont(fuente);
     nombre = new File("exe");

     Panel pan = new Panel();
     pan.add(ejecutar);
     pan.add(cerrar);

     Panel pan1 = new Panel();
     pan1.add(mensaje);

     Panel pan2 = new Panel();
     pan2.add(texto);

     add("North",pan2);
     add("Center",pan1);
     add("South",pan);

     ejecutar.enable();
     texto.enable();
     mensaje.enable();
     setResizable(false);

     pack();
     show();
  }
 public boolean action(Event ev, Object arg) {
   if((ev.target == cerrar)&&(ev.id == 1001)){
       System.exit(0);
    }

   // click en el boton ejecutar
   if((ev.target == ejecutar)&&(ev.id == 1001)){
         String comando = mensaje.getText();
         int contador=exe.contar(comando);
      if(contador==3){
          String[] arr=new String[3];
	  arr=exe.cargar(comando);
	  if(arr[0].equals("copiar ")){
                FileCopy.FileCopy(arr[1].substring(0,arr[1].length()-1),arr[2]);
		texto.append("comando: " + comando +"\n");
	  }
          if(arr[0].equals("renombrar ")){
                exe.renombrar(arr[1].substring(0,arr[1].length()-1),arr[2]);
		texto.append("comando: " + comando +"\n");
	  }
          if(!arr[0].equals("renombrar ") || !arr[0].equals("copiar ")){
              texto.append("comando: " + comando +"\n");
              texto.append("Error al ejecutar el comando...\n");
          }
          mensaje.setText("");
          return true;
      }
      if(contador==2){
          String[] arr=new String[2];
	  arr=exe.cargar(comando);
	  if(arr[0].equals("eliminar ")){
              exe.eliminar(arr[1]);
              texto.append("comando: " + comando +"\n");
	  }
	  if(arr[0].equals("ver ")){
              texto.append("comando: " + comando +"\n");
              archivo = new File(arr[1]);
              if(archivo.isFile()){
		try{
			RandomAccessFile r = new RandomAccessFile(archivo, "r");
			do{
				texto.append(r.readLine()+"\n");
			}while( r.getFilePointer() < r.length() );
		}catch(IOException e){    }
              }else{
                texto.append(archivo +" no es un archivo");
              }
	  }
          mensaje.setText("");
          return true;
      }
      if(comando.equals("arbol")){
          exe.ejecutar("tree");
          texto.append("comando: " + comando +"\n");
          mensaje.setText("");
          if(nombre.isFile()){
		try{
			RandomAccessFile r = new RandomAccessFile(nombre, "r");
			do{
				texto.append(r.readLine()+"\n");
			}while( r.getFilePointer() < r.length() );
		}catch(IOException e){    }
	}else{
		texto.append(nombre +" no es un archivo");
	}
          return(true);
      }
      if(comando.equals("exit")){
          System.exit(0);
      }
      if(comando.equals("limpiar")){
          texto.setText("");
          mensaje.setText("");
          return(true);
      }
      if(comando.equals("ayuda") || comando.equals("???")){
          texto.append("comando: " + comando +"\n");
          nombre = new File("src/ayuda");
          if(nombre.isFile()){
		try{
			RandomAccessFile r = new RandomAccessFile(nombre, "r");
			do{
				texto.append(r.readLine()+"\n");
			}while( r.getFilePointer() < r.length() );
		}catch(IOException e){    }
	}else{
		texto.append(nombre +" no es un archivo");
	}
        mensaje.setText("");
        nombre = new File("exe");
        return(true);
      }
      if(!comando.equals("")){
         texto.append("comando: " + mensaje.getText()+"\n");
         mensaje.setText("");
         exe.ejecutar(comando);
         if(nombre.isFile()){
		try{
			RandomAccessFile r = new RandomAccessFile(nombre, "r");
			do{
				texto.append(r.readLine()+"\n");
			}while( r.getFilePointer() < r.length() );
		}catch(IOException e){    }
	}else{
		texto.append(nombre +" no es un archivo");
	}
       }
    }
   return(true);
 }

 public static void activar(){
     ejecutar.enable();
     mensaje.enable();
  }
}