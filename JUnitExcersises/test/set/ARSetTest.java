package set;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class ARSetTest {
  @Test
  public void empty_set_should_have_size_zero() {
    ARSet emptySet = new ARSet();
    assertEquals(0, emptySet.size());
  }
  // här
  
  @Test
  public void set_should_have_added_integer() {
    ARSet elems = new ARSet();
    Integer i = 1;
    elems.add(i);
    assertTrue(elems.contains(i));
  }

  @Test
  public void set_should_have_added_list_of_integers() {
    ARSet elems = new ARSet();
    ARSet expected = new ARSet();
    Integer[] i = {1,2,3};
    elems.add(i);
    expected.add(new Integer[]{1,2,3});
    assertEquals(elems, expected);
  }

  @Test
  public void set_should_have_deleted_integer() {
    ARSet elems = new ARSet();
    Integer i = 1;
    Integer k = 2;
    elems.add(i);
    elems.add(k);
    elems.delete(i);
    assertTrue(!elems.contains(i) && elems.size() == 1);
  }

  @Test
  public void set_should_have_no_duplicates() {
    ARSet elems = new ARSet();
    elems.add(1);
    elems.add(1);
    assertTrue(elems.contains(1) && elems.size() == 1);
  }

  @Test
  public void set_should_compute_union() {
    ARSet expected = new ARSet();
    ARSet set1 = new ARSet();
    ARSet set2 = new ARSet();
    
    set1.add(new Integer[]{1, 2, 3, 4, 5});
    set2.add(new Integer[]{1, 2, 3, 6, 7});
    expected.add(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    assertEquals(set1.union(set2), expected);
  }
  
  @Test
  public void set_should_compute_intersection() {
    ARSet expected = new ARSet();
    ARSet set1 = new ARSet();
    ARSet set2 = new ARSet();
    
    set1.add(new Integer[]{1, 2, 3, 4, 5});
    set2.add(new Integer[]{1, 2, 3, 6, 7});
    expected.add(new Integer[]{1, 2, 3});

    assertEquals(set1.intersection(set2),expected);
  }

  @Test
  public void set_should_compute_subset() {
    ARSet set1 = new ARSet();
    ARSet set2 = new ARSet();
    ARSet set3 = new ARSet();
    
    set1.add(new Integer[]{1, 2, 3, 4, 5});
    set2.add(new Integer[]{1, 2});
    set3.add(new Integer[]{4, 5, 6});
    assertTrue(set2.isSubset(set1) && !set2.isSubset(set3));
  }

  @Test
  public void is_the_set_right_size() {
    ARSet set = new ARSet();
    set.add(1);

    assertEquals(1, set.size());
  }

  @Test
  public void does_set_contain() {
    ARSet set = new ARSet();
    int i = 1;
    set.add(i);
    
    assertTrue(set.contains(i));
  }

  @Test
  public void override_equals_method() {
    ARSet set1 = new ARSet();
    ARSet set2 = new ARSet();
    
    set1.add(new Integer[]{1, 2, 3, 4, 5});
    set2.add(new Integer[]{1, 2, 3, 4, 5});
    assertEquals(set1, set2);
  }
}
