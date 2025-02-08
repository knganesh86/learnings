import java.util.Objects;

public class Pair {
	int x;
	int y;
	  Pair(int i, int j){
          x=i;
          y=j;
      }
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		return x == other.x && y == other.y;
	}
}
