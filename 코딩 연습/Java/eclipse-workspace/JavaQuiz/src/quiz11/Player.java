package quiz11;

public class Player {

	private String name;
	private int hp;
	private int mp;
	
//	public String name;
//	public int hp;
//	public int mp;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	
	public void info() {
		System.out.println("닉네임:"+name);
		System.out.println("hp:"+hp+", mp:"+mp);
	}
	
	
	
}
