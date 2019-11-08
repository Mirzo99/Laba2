
public class Calculator {
    private double bufferNum;

    
    /** 
     * @return 
     */
    public Calculator() {
        this.bufferNum = 0;
    }

    
    /** 
     * @param num
     */
    public void setNum(double num){
        bufferNum = num;
    }

    
    /** 
     * @param num
     * @return double
     */
    public double plus(double num){
        return bufferNum+=num;
    }

    
    /** 
     * @param num
     * @return double
     */
    public double minus(double num){
        return bufferNum-=num;
    }

    
    /** 
     * @param num
     * @return double
     */
    public double div(double num){
        return bufferNum/=num;
    }

    
    /** 
     * @param num
     * @return double
     */
    public double multi(double num){
        return bufferNum*=num;
    }
}