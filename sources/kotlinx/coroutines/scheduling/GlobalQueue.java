package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeMPMCQueue;
import kotlinx.coroutines.internal.LockFreeMPMCQueueNode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u0004\u0018\u00010\u0002¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/GlobalQueue;", "Lkotlinx/coroutines/internal/LockFreeMPMCQueue;", "Lkotlinx/coroutines/scheduling/Task;", "()V", "add", "", "task", "removeFirstBlockingModeOrNull", "removeFirstIfNotClosed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* compiled from: Tasks.kt */
public class GlobalQueue extends LockFreeMPMCQueue<Task> {
    public final boolean add(Task task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        while (true) {
            LockFreeMPMCQueueNode tailValue = getTailValue();
            LockFreeMPMCQueueNode lockFreeMPMCQueueNode = (LockFreeMPMCQueueNode) tailValue.getNextValue();
            if (lockFreeMPMCQueueNode != null) {
                tailCas(tailValue, lockFreeMPMCQueueNode);
            } else {
                if (!(tailValue != TasksKt.getCLOSED_TASK())) {
                    return false;
                }
                LockFreeMPMCQueueNode lockFreeMPMCQueueNode2 = task;
                if (tailValue.nextCas(null, lockFreeMPMCQueueNode2)) {
                    tailCas(tailValue, lockFreeMPMCQueueNode2);
                    return true;
                }
            }
        }
    }

    public final Task removeFirstIfNotClosed() {
        LockFreeMPMCQueueNode lockFreeMPMCQueueNode;
        while (true) {
            LockFreeMPMCQueueNode headValue = getHeadValue();
            lockFreeMPMCQueueNode = (LockFreeMPMCQueueNode) headValue.getNextValue();
            if (lockFreeMPMCQueueNode != null) {
                if (((Task) lockFreeMPMCQueueNode) != TasksKt.getCLOSED_TASK()) {
                    if (headCas(headValue, lockFreeMPMCQueueNode)) {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        lockFreeMPMCQueueNode = null;
        return (Task) lockFreeMPMCQueueNode;
    }

    public Task removeFirstBlockingModeOrNull() {
        LockFreeMPMCQueueNode lockFreeMPMCQueueNode;
        while (true) {
            LockFreeMPMCQueueNode headValue = getHeadValue();
            lockFreeMPMCQueueNode = (LockFreeMPMCQueueNode) headValue.getNextValue();
            if (lockFreeMPMCQueueNode != null) {
                if (((Task) lockFreeMPMCQueueNode).getMode() == TaskMode.PROBABLY_BLOCKING) {
                    if (headCas(headValue, lockFreeMPMCQueueNode)) {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        lockFreeMPMCQueueNode = null;
        return (Task) lockFreeMPMCQueueNode;
    }
}
