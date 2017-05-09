package 工厂模式;

public class ChigagoStore extends PizzaStore{

	@Override
	public Pizza createPizza(String type) {
		if(type.equals("veggie")){
			return new ChicagoStyleVeggiePizza();
		}else if(type.equals("pepperoni")){
			return new ChigagoStylePepperoniPizza();
		}else return null;
	}
	
}
