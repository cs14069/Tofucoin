package Main;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;
import java.util.Map;

import net.arnx.jsonic.JSON;

public class Block implements Externalizable {
	private final static int NONCE_LENGTH = 512;
	private final static int WALLET_LENGTH = 512;
	
	private static byte[] myAddr;

	private BlockHeader header;
	private int txCnt;
	private Transaction[] txList;

	static void init() {
		Log.log("Block init done.");
	}

	public Block() {
		byte[] timestamp = new byte[Constant.BYTE_TIMESTAMP];
		header = new BlockHeader(Constant.BlockHeader.VERSION, new byte[Constant.Block. BYTE_BLOCK_HASH], timestamp, new byte[Constant.Block.BYTE_NONCE], Setting.getMyAddr());
		txCnt = 0;
		txList = new Transaction[Constant.Block.MAX_TX];
		for(int i = 0; i < Constant.Block.MAX_TX; i++) {
			txList[i] = null;
		}
	}

	synchronized boolean addTransaction(Transaction tx) {
		txList[txCnt] = tx;
		txCnt++;
		return true;
	}
	byte[] getPrevBlockHash() {
		return header.getPrevBlockHash();
	}

	@Override
	public void readExternal(ObjectInput oi) throws IOException, ClassNotFoundException {
		System.out.println("block read");
		header = (BlockHeader) oi.readObject();
		txCnt = oi.readInt();
		txList = (Transaction[]) oi.readObject();
		//		for(int i = 0; i < txCnt; i++) {
//			txList[i] = (Transaction) oi.readObject();
//		}
	}

	@Override
	public void writeExternal(ObjectOutput oo) throws IOException {
		System.out.println("block write");
		oo.writeObject(header);
		oo.writeInt(txCnt);
		oo.writeObject(txList);
	}

	public String toString() {
		return "[header: " + header.toString() + ", txList: " + txList.toString() + "]";
	}
}
