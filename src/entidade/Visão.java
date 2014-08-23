package entidade;

public class Visão{
  
  String info;

    public Visão(String info) {
        this.info = info;
    }


    public String getInfo() {
        return info;
    }

  @Override
  public String toString()
  {
    return info;
  }
  
}

