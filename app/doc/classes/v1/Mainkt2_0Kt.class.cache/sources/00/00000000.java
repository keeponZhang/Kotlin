package cn.kotliner.coroutine.p000ui.mainkt2;

import cn.kotliner.coroutine.ui.MainWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 2, d1 = {"��\u0014\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0019\u0010��\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"main", "", "args", "", "", "([Ljava/lang/String;)V", "app_debug"})
/* renamed from: cn.kotliner.coroutine.ui.mainkt2.Mainkt2_0Kt */
/* loaded from: Mainkt2_0Kt.class */
public final class Mainkt2_0 {
    public static final void main(@NotNull String[] args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        MainWindow frame = new MainWindow();
        frame.setTitle("Coroutine@Bennyhuo");
        frame.setSize(200, 150);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(3);
        frame.init();
        frame.setVisible(true);
        frame.onButtonClick(new Mainkt2_0Kt$main$1(frame));
    }
}