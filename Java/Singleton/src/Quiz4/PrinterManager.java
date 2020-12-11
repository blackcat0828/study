package Quiz4;

import java.util.ArrayList;

public class PrinterManager {
    private static PrinterManager mgr = null;
    private ArrayList<Printer> managedPrinters = new ArrayList<>();

    private PrinterManager(){
        managedPrinters.add(new Printer());
        managedPrinters.add(new Printer());
        managedPrinters.add(new Printer());
    }

    public synchronized static PrinterManager getPrinterManager(){
        if(mgr==null){
            mgr = new PrinterManager();
        }
        return mgr;
    }

    public synchronized Printer getPrinter(){
        while(true){
            for (Printer printer: managedPrinters){
                if(printer.isAvailable()){
                    printer.setAvailable(false);
                    return printer;
                }
            }
        }
    }
}
