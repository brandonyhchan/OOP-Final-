package org.example;/*
Chain of responsibility is handling a request by layers of processors.
Analogy: Customer calls customer service, gets answered by the reps, then passed to the general tech service,
then to the actual technician.
 */

/**
 * The a class to represent the chain of responsibility.
 */
public class Chain
{
  Processor chain;//a chain of processor (who answers the phone)

  public Chain(){ //constructor to build the chain
    buildChain();
  }

  private void buildChain(){
    chain = new NegativeProcessor(
        new ZeroProcessor(
            new PositiveProcessor(null)));
  }

  public void process(Number request) { //num of request
    chain.process(request);
  }

}

abstract class Processor //abstract processor (who answers the phone)
{
  private Processor nextProcessor;

  public Processor(Processor nextProcessor){
    this.nextProcessor = nextProcessor;
  };

  //if there's someone on the line, let them handle the request I can't deal with
  public void process(Number request){
    if(nextProcessor != null)
      nextProcessor.process(request);
  };
}

class Number //the request class
{
  private int number;

  public Number(int number)
  {
    this.number = number;
  }

  public int getNumber()
  {
    return number;
  }

}

//The customer service representative who handles negative numbers
class NegativeProcessor extends Processor
{
  //building the chain so it's possible to pass it on to the next person
  public NegativeProcessor(Processor nextProcessor){
    super(nextProcessor);

  }

  //the method to process the request
  public void process(Number request)
  {
    if (request.getNumber() < 0) //if it's a negative num, process it
    {
      System.out.println("NegativeProcessor : " + request.getNumber());
    }
    else //or pass the request to the next layer
    {
      super.process(request);
    }
  }
}

//the processor that deals with 0
class ZeroProcessor extends Processor
{
  //establish the next layer
  public ZeroProcessor(Processor nextProcessor){
    super(nextProcessor);
  }

  //process the request
  public void process(Number request)
  {
    if (request.getNumber() == 0)//deal with 0
    {
      System.out.println("ZeroProcessor : " + request.getNumber());
    }
    else
    {//or pass it on
      super.process(request);
    }
  }
}

//the processor that deals with positive num
class PositiveProcessor extends Processor
{

  //establish the next layer
  public PositiveProcessor(Processor nextProcessor){
    super(nextProcessor);
  }

  //process the request
  public void process(Number request)
  {
    if (request.getNumber() > 0) //deal with positive num
    {
      System.out.println("PositiveProcessor : " + request.getNumber());
    }
    else
    { //or pass to the next layer
      super.process(request);
    }
  }
}

class TestChain
{
  public static void main(String[] args) {
    Chain chain = new Chain();

    //Calling chain of responsibility
    chain.process(new Number(90));
    chain.process(new Number(-50));
    chain.process(new Number(0));
    chain.process(new Number(91));
  }
}
