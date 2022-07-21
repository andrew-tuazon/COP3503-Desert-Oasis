import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Oasis
{
	//Friend class implementing comparable
	public static class Friend implements Comparable<Friend>
	{
		long x, y;
		String name;
		
		//Constructor for Friend
		Friend(long x, long y, String name)
		{
			this.x = x;
			this.y = y;
			this.name = name;
		}

		//Custom sort compare method
		@Override
		public int compareTo(Friend o)
		{
			return Long.compare(getDistance(), o.getDistance());
		}
		
		//Get distance using distance formula
		private long getDistance()
		{
			long dist = (x * x) + (y * y);
			return dist;
		}
	}
	
	public static void main (String[] args)
	{
		int numFriends;
		long distX, distY;
		Scanner sc =  new Scanner(System.in);
		numFriends = sc.nextInt();
		distX = sc.nextLong();
		distY = sc.nextLong();
		
		//ArrayList for Friend objects
		ArrayList<Friend> friendList = new ArrayList<Friend>(numFriends);
		
		//Read input and add Friends to friendList
		while(numFriends-->0)
		{
			long xCoord, yCoord;
			String name;
			xCoord = Long.parseLong(sc.next());
			yCoord = Long.parseLong(sc.next());
			name = sc.next();
			friendList.add(new Friend(xCoord - distX, yCoord - distY, name));
		}
		
		//ArrayList sort
		Collections.sort(friendList);
		
		//Print out names in ascending order of distance
		for(Friend f : friendList)
		{
			System.out.println(f.name);
		}
	}
}