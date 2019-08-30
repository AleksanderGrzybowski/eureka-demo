package pl.kelog.eurekademo.shared;

public class IsPrimeResponse {
    
    private boolean isPrime;
    
    public IsPrimeResponse() {}
    
    public IsPrimeResponse(boolean isPrime) {
        this.isPrime = isPrime;
    }
    
    public boolean isPrime() {
        return isPrime;
    }
    
    public void setPrime(boolean prime) {
        isPrime = prime;
    }
}
