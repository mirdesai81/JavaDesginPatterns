package com.java.thread;

/**
 * This can create DeadLock since hasValue can be cached to CPU memory.
 * marking hasValue to volatile is OK in this case since
 * any write to value happens before volatile write so ordering of instruction for value is not changed by JVM
 * similarly any read to value happens after volatile read so it is OK
 *
 */
public class ProducerConsumer {
    private Integer value;

    // once consumed hasValue will be false;
    // once produced hasValue will be true
    private Boolean hasValue = false;

    public void produce(Integer value) {
        // This will run untill hasValue is set to false from consumer
        // initial is false so one can produce value first and then goes into waiting state
        while(hasValue) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        System.out.println("Producing "+value+ " as next consumable.");
        this.value = value;
        hasValue = true;
    }

    public Integer consume() {
        // it will not consume value untill it is produced by setting hasValue to true
        while(!hasValue) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        Integer value = this.value;
        System.out.println("Consumed "+value);
        hasValue = false;
        return value;
    }


}
