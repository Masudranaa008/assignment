public class BookingService {
    private PaymentService paymentService;
    public BookingService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean book(){
        return this.paymentService.processPayment();
    }
}
