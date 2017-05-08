package think;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

class Iable implements Iterable<String>{

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<String>() {
			String[] words="wo shi zhong guo ren".split(" ");
			int index=0;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index<words.length;
			}

			@Override
			public String next() {
				// TODO Auto-generated method stub
				return words[index++];
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}
		};
	}
	
}
class Rlist<T> extends ArrayList<T>{
	public Rlist(Collection<T> c) {
		super(c);
	}
	public Iterable<T> reversed(){
		return new Iterable<T>() {

			@Override
			public Iterator<T> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<T>() {
					int current=size()-1;
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return current>-1;
					}

					@Override
					public T next() {
						// TODO Auto-generated method stub
						return get(current--);
					}

					@Override
					public void remove() {
						// TODO Auto-generated method stub
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
	public Iterable<T> randomed(){
		return new Iterable<T>() {

			@Override
			public Iterator<T> iterator() {
				// TODO Auto-generated method stub
				List<T> list=null;
				try {
					list = (ArrayList<T>) clone();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Collections.shuffle(list);
				return list.iterator();
			}
			
		};
		
	}
}
public class JavaInterator {
	/**
	 * AbstractCollection we also should use iterator,
	 * so the best method is implments Iterator
	 */
	class Col extends AbstractCollection<String>{

		@Override
		public Iterator<String> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	static class Ite implements Iterator{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * inner class:1 new JavaInterator().new Col() or 2 use static
		 */
		/**
		 * can return iterator or implements iterator
		 */
		String[] strings="to be or not to be".split(" ");
		Rlist<String> rlist=new Rlist<>(Arrays.asList(strings));
		List<String> lstrings=new ArrayList<>(Arrays.asList(strings));
		List<String> astrings=Arrays.asList(strings);
		/**
		 * Arrays.asList use the underlying arrays as a physical implementation
		 * the reference of every
		 */
		System.out.println(Arrays.toString(strings));
		Collections.shuffle(astrings);
		System.out.println("strings:"+Arrays.toString(strings));
		System.out.println("lstrings:"+lstrings);
		/**
		 * two util class
		 * collections and Arrays 
		 */
		for (String string : rlist) {
			System.out.println(string);
		}
		for (String string : rlist.reversed()) {
			System.out.println(string);
		}
		for (String string : new Iable()) {
			System.out.println(string);
		}
		Integer[] is=new Integer[]{11,2,3,4,5,6,7,8,9,11};
		ArrayList<Integer> list=new ArrayList<>(Arrays.asList(is));
		LinkedList<Integer> list2=new LinkedList<>(Arrays.asList(is));
		Set<Integer> set=new HashSet<>(Arrays.asList(is));
		/**
		 * keySet
		 * values
		 * containsKey
		 * containsValue
		 */
		Map<Integer,Integer> map=new HashMap<>();
		/**
		 * peek----element(NoSuchElementException)-return first
		 * poll----remove(NoSuchElementException)-return first and remove
		 */
		Queue<Integer> queue =list2;
		Comparator<Character> com = new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
			
		};
		/**
		 * priority only when we get the first of  queue
		 * we should make ourself comparator
		 */
		PriorityQueue<Character> pq=new PriorityQueue<>(5,com);
		pq.addAll(Arrays.asList('a','c','b','d','e'));
		System.out.println("PriorityQueue:"+pq.poll());
		System.out.println("PriorityQueue:"+pq.poll());
		Stack<Integer> stack =new Stack<>();
		/**
		 * treeSet --- redblack tree
		 * hashSet --- hash table
		 */
		SortedSet<String> sSet=new TreeSet<>(Arrays.asList("bb","ba","bc"));
		
		
		System.out.println("sorted:"+sSet);
		for (int i = 0; i < 100; i++) {
			int r=new Random().nextInt(20);
			Integer sum=map.get(r);
			map.put(r, sum==null?i:sum+i);
		}
		System.out.println("map:"+map.entrySet());
		/**
		 * entrySet is faster than keySet.
		 */
		ListIterator it=list.listIterator();
		//System.out.println(it.next());
		//System.out.println(it.previous());
		//System.out.println(it.previousIndex());
		Integer[] is2=new Integer[]{1,2,3,4,5,6,7,8,9,11};
		Collection colect=list;
		//Collections.shuffle(list);
		colect.addAll(Arrays.asList(15,24));
		System.out.println(list);
		System.out.println(Collections.binarySearch(list, 30));
		print(is2);
	}
	public static void print(Integer[] s){
		for (Object object : s) {
			System.out.println(object);
		}
	}

}
