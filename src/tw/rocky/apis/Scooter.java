package tw.rocky.apis;

//延伸Bike物件，需要有"建構式"
//只會使用父類別無傳直建構式
public class Scooter extends Bike{
	private int gear;
	
//	public void changeGear(int gear) {
//		if(gear >= 0 && gear <=4) {
//			this.gear = gear;
//		}
//	}
	
	public boolean changeGear(int gear) {
		if(gear >= 0 && gear <=4) {
			this.gear = gear;
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void upSpeed() {
		// TODO Auto-generated method stub
		// super.upSpeed(); 呼叫父類別來使用
		speed += 5;
		
	}
}
