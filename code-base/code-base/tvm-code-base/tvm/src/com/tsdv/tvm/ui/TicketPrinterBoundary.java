package com.tsdv.tvm.ui;

import java.io.NotActiveException;

import com.tsdv.device.LocalTicketPrinter;
import com.tsdv.device.TicketPrinter;

public class TicketPrinterBoundary {
	private static TicketPrinter printer = LocalTicketPrinter.instance();

	public static boolean isOnline() {
		try {
			return printer.isOnline();
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean hasEnoughPapers(int numberOfPaper) {
		try {
			return printer.hasEnoughPapers(numberOfPaper);
		} catch (Exception e) {
			return false;
		}
	}

	public static String printTicket(String formattedString) throws NotActiveException {
		if (!isOnline()) {
			throw new NotActiveException("Printer not available");
		}
		return printer.print(formattedString);
	}
}
