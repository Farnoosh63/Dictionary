import java.util.ArrayList;
// import java.time.LocalDateTime;

public class Definition {
  private String mMeaning;
  // private boolean mCompleted;
  // private LocalDateTime mCreatedAt;
  private static ArrayList<Definition> instances = new ArrayList<Definition>();
  // private int mId;
  //
  public Definition(String statement) {
    mMeaning = statement;
  //   mCompleted = false;
  //   mCreatedAt = LocalDateTime.now();
    instances.add(this);
  //   mId = instances.size();
  }

  public String getMeaning() {
    return mMeaning;
  }
  //
  // public boolean isCompleted() {
  //   return mCompleted;
  // }
  //
  // public LocalDateTime getCreatedAt() {
  //   return mCreatedAt;
  // }

  public static ArrayList<Definition> all() {
    return instances;
  }
  //
  // public static void clear() {
  //   instances.clear();
  // }
  //
  // public int getId() {
  //   return mId;
  // }
  //
  // public static Definition find(int id) {
  //   try {
  //     return instances.get(id - 1);
  //   } catch (IndexOutOfBoundsException e) {
  //     return null;
  //   }
  // }
}
