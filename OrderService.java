package pelijee.services;

import ...


/**
 * Created by caric on 1/7/15.
 */
@Stateless
public class OrderService {

	private static final Logger log = LoggerFactory.getLogger(OrderService.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	...

	
	public String insert(@Valid Order order) {
		prepareOrderForInsert(order);
		prepareOrderForUpdate(order, ReservationChangeType.EDIT);
		String orderId = dm.insert(order);
		order.setId(orderId);

		// create SQL products for a new Order
		createSqlProducts(order.getProducts(), orderId);

		// set Super order id if is not defined by user
		if(orderId != null && (order.getSuperOrderId() == null || order.getSuperOrderId().isEmpty())) {
			order.setSuperOrderId(orderId);
			this.update(order);
		}
//		if (updateGalileoProducts(order)) {
//			dm.update(order);
//		}
//		if (updateAmadeusProducts(order)) {
//			dm.update(order);
//		}
		/**
		 * tu si budeme odkladat dalsie info o objednavke do DB
		 * aby sme nemuseli napr pri zmene flagov vytvarat novu verziu v elasticu
		 */
		OrdersData ordersData = new OrdersData(order);
		dbTransactionManager.insertOrdersData(ordersData);
		addOrdersDataToRegisteredUser(ordersData);

		return orderId;
	}

	/**
	 * This method save ordersData to Table "orders_data_registered_user" for registered user.
     * @param ordersData
	 * @autor Marek Tomas
     */
	private void addOrdersDataToRegisteredUser(OrdersData ordersData) {
		RegisteredUser registeredUser = registeredUserHelper.getRegisteredUserFromSession();
		if (registeredUser != null && ordersData != null) {
			registeredUser.getOrdersData().add(new OrdersDataRegisteredUser(ordersData, registeredUser));
			try {
				entityManager.merge(registeredUser);
			} catch (PersistenceException e) {
				log.error("OrdersData id already exist in DB.");
			}
		} else {
			log.error("OrdersData not added, registeredUser from session is null!");
		}
	}

}
