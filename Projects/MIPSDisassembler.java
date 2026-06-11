package Projects;
public class MIPSDisassembler {
	
	public static void main(String[] args) {

		// List of 11 Instructions
		int[] instructions = {
			0x032BA020, 0x8CE90014, 0x12A90003, 0x022DA822, 0xADB30020, 0x02697824, 0xAE8FFFF4, 0x018C6020,
			0x02A4A825, 0X158FFFF7, 0X8ECDFFF0,
		};
		// Starting posistion for first instruction
		int address = 0x9A040;

		for (int inst: instructions) {

			int opcode = (inst >>> 26) & 0x3f; // Shift right 26 and mask lower 6 bits

			// R-Type
			if (opcode == 0) {

				int src1 = (inst >>> 21) & 0x1F; // shift right 21 and mask lower 5 bits
				int src2 = (inst >>> 16) & 0x1F; // shift right 16 and mask lower 5 bits
				int dst = (inst >>> 11)  & 0x1f; // shift right 11 and mask lower 5 bits
				int func = inst & 0x3F; // Isolates lower 6 bits for function call

				// variable for operation call
				String operation = "";

				switch(func) {
					case 32:
						operation = "add";
						break;
					case 34:
						operation = "sub";
						break;
					case 36:
						operation = "and";
						break;
					case 37:
						operation = "or";
						break;
					default:
						return;
				}
				// Prints out instruction using place holders
				System.out.printf("%X %s $%d, $%d, $%d\n", address, operation, dst, src1, src2);


			}
			// I-type
			else {
				int src1 = (inst >>> 21) & 0x1F; // shift right 21 and mask lower 5 bits
				int dst = (inst >>> 16) & 0x1F; // shift right 16 and mask lower 5 bits
				short offset = (short)(inst & 0xFFFF); //extracts offset and converts to short

				switch (opcode) {
					// Load
					case 35: 
						System.out.printf("%X lw $%d, %d ($%d)\n", address, src1, offset, dst);
						break;
					// Store
					case 43:
						System.out.printf("%X sw $%d, %d ($%d)\n", address, src1, offset, dst);
					// Branch on equal
					case 4:
					{
						// Adds 4 to increase program counter and shift left 2 to get the target address
						int target = address + 4 + (offset << 2);
						System.out.printf("%X beq $%d, %d ($%d), address %X\n", address, src1, offset, dst, target);
						break;
					}
					// Branch on Not Equal	
					case 5:
					{
						// Adds 4 to increase program counter and shift left 2 to get the target address
						int target = address + 4 + (offset << 2);
						System.out.printf("%X bne $%d, %d ($%d), address %X\n", address, src1, offset, dst, target);
						break;
					}
				}
			}

			address += 4;

		}

		
	}
}	