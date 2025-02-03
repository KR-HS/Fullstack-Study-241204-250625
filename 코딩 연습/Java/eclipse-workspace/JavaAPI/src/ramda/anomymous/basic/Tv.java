package ramda.anomymous.basic;

public class Tv {

	private int sound;
	private RemoteControl remote = new RemoteControl() {
		@Override
		public void volumeUp() {
		}
		@Override
		public void volumeDown() {
		}
		@Override
		public void turnOn() {
		}
		@Override
		public void turnOff() {
		}
	};
}
