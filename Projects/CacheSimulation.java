package Projects;

import java.util.Scanner;

public class CacheSimulation {
	
	// Creating Main mem array of 2K 
	static int[] MainMem = new int[2048]; 
	// Create a new 16 array -> Block size 16 bytes
	static CacheSection[] cache = new CacheSection[16];
	
	
	public static void main(String[] args) {
		
		// create an input for user
		Scanner input = new Scanner(System.in);
		
		// initialize both main mem and cache 
		initMemory();
		initCache();
		
		while (true) {
			// Displaying what the user wants to do; Read, Write, or Display
			System.out.println("(R)ead, (W)rite, (D)isplay Cache");
			String op = input.nextLine().toUpperCase();
			
			switch (op) {
			
				case "R":
					System.out.println("Enter Hex Address: ");
					// reads the hex address and coverts to an int
					int rAddr = Integer.parseInt(input.nextLine(), 16);
					read(rAddr);
					break;
					
				case "W":
					System.out.println("Enter Hex Address: ");
					// reads hex address and converts to int
					int wAddr = Integer.parseInt(input.nextLine(), 16);
					
					System.out.println("Enter what you want to change that address too: ");
					// reads value to the write method 
					int data = Integer.parseInt(input.nextLine(), 16);
					
					write(wAddr, data);
					break;
				
				case "D":
					// calls display method 
					displayCache();
					break;
				
			}
			
		}
		
	}
	
	// Initialize Main memory
	static void initMemory() {
		for (int i = 0; i < 2048; i++) {
			MainMem[i] = i % 256; // x00 - xFF
		}
	}
	
	// Initialize Cache
	static void initCache() {
		// create loop of 16 lines and have each line empty at first
		for (int i = 0; i < 16; i++) {
			cache[i] = new CacheSection();
		}
	}
	
	// Read Method
	static void read(int address) {
		// gets lower 4 bits for offset
		int offset = address & 0xF;
		// gets the next for bits bit shifting right 4
		int index = (address >> 4) & 0xF;
		// gets top 3 bits and checks if blocks are equal
		int tag = (address >> 8) & 0x7;
		// removes offset and starts block at beginning address
		int blockStart = address & 0xFF0;
		
		// getting the cache line
		CacheSection section = cache[index];
		// if hit is true, then tag matches and valid bit matches
		boolean hit = section.valid && section.tag == tag;
		
		// if miss, load the block into cache and update addresses
		if (!hit) {
			handleMiss(index, tag, blockStart);
			section = cache[index];
		}
		
		// retrieve correct byte from block
		int value = section.data[offset];
		
		System.out.printf("Address being read: %03X | %s | Value: %02X\n", 
				address, hit ? "Cache hit" : "Cache Miss", value);

	}
	
	// Write Method (write-back)
	static void write(int address, int value) {
		// same shifting as read above
		int offset = address & 0xF;
		int index = (address >> 4) & 0xF;
		int tag = (address >> 8) & 0x7;
		int blockStart = address & 0xFF0;
		
		// retrieving cache line
		CacheSection section = cache[index];
		// checks if tag and valid bits match
		boolean hit = section.valid && section.tag == tag;
		
		// if miss, load block into cache and update addresses 
		if (!hit) {
			handleMiss(index, tag, blockStart);
			section = cache[index];
		}
		// changes cache only
		section.data[offset] = value;
		// update dirty bit to be 1, block is dirty
		section.dirty = true;
		
		System.out.printf("Address being written to: %03X | %s | Value Written: %02X\n", 
				address, hit ? "Cache Hit" : "Cache Miss", value);
		

	}
	
	// Handle Cache Miss
	static void handleMiss(int index, int newTag, int blockStart) {
		
		// get cache line
		CacheSection section = cache[index];
		
		// If bit is dirty write back to main mem
		if (section.valid && section.dirty) {
			// restore original memory address for that block
			int oldBlockStart = (section.tag << 8) | (index << 4);
			
			// after updating, writes block back to mem
			for (int i = 0; i < 16; i++) {
				MainMem[oldBlockStart] = section.data[i];
			}
		}
		
		// Load new Block from main mem
		for (int i = 0; i < 16; i++) {
			section.data[i] = MainMem[blockStart + i];
		}
		
		section.valid = true;
		section.dirty = false;
		section.tag = newTag;
		
	}
	
	// Display Cache
	
	static void displayCache() {
		System.out.println("Slot V D Tag  Data");
		
		for (int i = 0; i < 16; i++) {
			
			CacheSection section = cache[i];
			
			 System.out.printf("%X    %d %d  %X   ", i, section.valid ? 1 : 0, section.dirty ? 1 : 0, section.tag);
			// prints 16 bytes of that block 
			 for (int j = 0; j < 16; j++) {
				 System.out.printf("%02X ", section.data[j]);
			 }
			 
			 System.out.println();
			
		}
	}	
}

//Create a class, to initialize the sections of the cache: Tag, Slot, Block #, Dirty bit, etc.
class CacheSection {
	
	// initialize the valid bit
	public boolean valid;
	// initialize the dirty bit
	public boolean dirty;
	//initialize the tag
	int tag;
	//initialize the cache size
	int[] data = new int[16]; // -> Block size = 16 bytes
	
	// Create a constructor and initialize everything to 0 or false by default
	public CacheSection() {
		valid = false;
		dirty = false;
		tag = 0;
		// Create loop to fill array with all 0s initially
		for(int i = 0; i < 16; i++) {
			data[i] = 0;
		}
	}

}