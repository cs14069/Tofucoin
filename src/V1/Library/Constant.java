package V1.Library;

public class Constant {
	// 他のクラスから参照する定数はConstantへ、それ以外はそれぞれのクラスにprivateとして設定したほうがよいか
	// それだと、どこにどんな定数があったかが分かりづらくなる
	// 他のクラスから参照してほしくない変数は別に無いと思うのでこれでいいか
	// final宣言してあるから改変されることは無い
	
	private Constant() {
	}

	public static final int TEST_NETWORK = 1;
	public static final int PRODUCT_NETWORK = 2;

	public static final int BYTE_TIMESTAMP = 4;

	public static class Address {
		private Address() {
		}

		public static final int BYTE_ADDRESS = 32;
		public static final int BYTE_PRIVATE_KEY = 64;
		public static final int BYTE_PUBLIC_KEY = 64;
		public static final int BYTE_PRIVATE_KEY_PREFIX = 32;
		public static final int BYTE_PUBLIC_KEY_PREFIX = 24;
		public static final String PRIVATE_KEY_PREFIX = "303E020100301006072A8648CE3D020106052B8104000A042730250201010420";
		public static final String PUBLIC_KEY_PREFIX = "3056301006072A8648CE3D020106052B8104000A03420004";
	}

	public static class Blockchain {
		private Blockchain() {
		}
		
		public static final int SAVE_FILE_PER_DIR = 1000;
		public static final int MAX_PREV_BLOCK_HASH_LIST = 6;
	}

	public static class BlockHeader {
		private BlockHeader() {
		}

		public static final int VERSION = 1;
	}

	public static class Block {
		private Block() {
		}

		public static final int VERSION = 1;
		public static final int MAX_TX = 100;
		public static final int BYTE_BLOCK_HASH = 64;
		public static final int BYTE_NONCE = 64;
	}
	public static class Crypto {
		private Crypto() {
		}
		public static final String SIGN_ALGO = "SHA256withECDSA";
	}

	public static class NetworkObject {
		private NetworkObject() {
		}

		public static final int BLOCK = 1;
		public static final int TX = 2;
	}

	public static class Transaction {
		private Transaction() {
		}

		public static final int OUTPUT_IS_NOT_ENOUGH = -1;

		public static final int VERSION = 1;
		public static final int BYTE_TX_HASH = 64;

		public static final int MAX_INPUT_OUTPUT = 31;
		
		public static final int BYTE_MAX_SIGNATURE = 512;
	}


	public static class Server {
		private Server() {
		}

		public static final int SERVER_READ_SLEEP = 1000;
		public static final int SERVER_PORT = 8081;
		public static final int SERVER_BUF = 1024 * 1024; // 1MB
	}
	public static class Stack {
		private Stack() {}
		
		public static final int LENGTH_MAX_STACK = 100;
		
		public static final int NOTHING_IN_STACK = Script.OPCode.FALSE;
	}

	public static class Log {
		private Log() {
		}

		public static final String NORMAL = "\u001b[00;40m \u001b[00;30m";
		public static final String IMPORTANT = "\u001b[00;46m \u001b[00;36m";
		public static final String TEMPORARY = "\u001b[00;47m ";
		public static final String EXCEPTION = "\u001b[00;41m \u001b[00;31m";
		public static final String INVALID = "\u001b[00;45m \u001b[00;35m";
	}

	// class file does not exists
	public static class Environment {
		private Environment() {
		}

		public static final String SEPARATOR = System.getProperty("file.separator");
	}

	public static class Script {
		private Script() {
		}
		public static final int BYTE_MAX_ANSWER = 100;
		public static final int BYTE_MAX_QUESTION = 100;
		
		public static final int LENGTH_REGISTER = 10;
		
		public static class OPCode {
			public static byte FALSE = 0x00;
			public static byte TRUE = 0x01;
			public static byte END = 0x02;

			public static byte PUSH512 = 0x10;	// push to stack
			public static byte PUSH256 = 0x11;	// push to stack
			public static byte PUSH160 = 0x12;	// push to stack
			public static byte PUSH128 = 0x13;	// push to stack
			public static byte PUSH72 = 0x14;	// push to stack
			public static byte PUSH64 = 0x15;	// push to stack
			public static byte PUSH32 = 0x16;	// push to stack
			
			public static byte POP1_0 = 0x20;	// pop 1 byte to register1 from stack
			
			public static byte EQUAL = 0x30;
			public static byte EQUAL_VERIFY = 0x31;
			public static byte IF = 0x31;
			
			public static byte HASH_TWICE = 0x40;	// double hash (sha256)
//			public static byte HASH160 = 0x41;	// hash (sha256) and hash (ripemd160)
			
			public static byte CHECK_SIG = 0x50;	// sig
			
			public static byte DUP = 0x60;	// duplicate stack top data
			public static byte DUP_PUSH = 0x61;	// duplicate stack top data and push
			public static byte PUBK_DUP = 0x62;	// duplicate stack top data (attach public key prefix)
		}
		public enum Result{
			FAILED, SOLVED
		}
		public enum State {
			OP, END, PUSH, POP
		}

	}

}
