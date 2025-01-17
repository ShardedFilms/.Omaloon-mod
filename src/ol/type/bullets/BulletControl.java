package ol.type.bullets;

import arc.math.geom.Vec2;
import arc.struct.IntSet;
import kotlin.jvm.internal.Intrinsics;

public final class BulletControl {
    public int get(IntSet $this$get, int index) throws Throwable {
        Intrinsics.checkNotNullParameter($this$get, "$this$get");
        int counter = 0;
        IntSet.IntSetIterator iterator = $this$get.iterator();
        if (index >= 0 && index < $this$get.size) {
            while(iterator.hasNext) {
                int value = iterator.next();
                if (counter == index) {
                    iterator.reset();
                    return value;
                }

                ++counter;
            }

            throw new IllegalArgumentException();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    public interface Targeting {
        Vec2 targetPos();
    }
}