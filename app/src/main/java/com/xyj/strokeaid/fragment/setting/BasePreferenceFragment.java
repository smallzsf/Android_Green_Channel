package com.xyj.strokeaid.fragment.setting;

import android.preference.PreferenceFragment;

public abstract class BasePreferenceFragment extends PreferenceFragment {

   /* *//* renamed from: a *//*
    public static final C2732a f7579a = new C2732a(null);

    *//* renamed from: b *//*
    private HashMap f7580b;

    @C4107i(mo15053a = {1, 1, 13}, mo15054b = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo15055c = {"Lcom/nl/greenchannel/fragment/setting/BasePreferenceFragment$Companion;", "", "()V", "parseBaseUrl", "", "baseUrl", "", "app_release"})
    *//* renamed from: com.nl.greenchannel.fragment.setting.BasePreferenceFragment$a *//*
    *//* compiled from: BasePreferenceFragment.kt *//*
    public static final class C2732a {
        private C2732a() {
        }

        public *//* synthetic *//* C2732a(C4144f fVar) {
            this();
        }

        *//* renamed from: a *//*
        public final boolean mo11106a(String str) {
            C4147i.m13762b(str, "baseUrl");
            if (!TextUtils.isEmpty(str)) {
                C5891w d = C5891w.f15755a.mo19580d(str);
                if (d != null) {
                    List q = d.mo19552q();
                    return C4147i.m13760a((Object) "", (Object) (String) q.get(q.size() - 1));
                }
            }
            return false;
        }
    }

    *//* renamed from: a *//*
    public abstract void mo11091a();

    *//* renamed from: b *//*
    public abstract void mo11092b();

    *//* renamed from: c *//*
    public abstract void mo11093c();

    *//* renamed from: d *//*
    public abstract void mo11094d();

    *//* renamed from: e *//*
    public void mo11095e() {
        if (this.f7580b != null) {
            this.f7580b.clear();
        }
    }

    public *//* synthetic *//* void onDestroyView() {
        super.onDestroyView();
        mo11095e();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo11091a();
        mo11092b();
        mo11093c();
        mo11094d();
    }

    *//* access modifiers changed from: protected *//*
    *//* renamed from: a *//*
    public final boolean mo11102a(Preference preference, String str, String str2) {
        C4147i.m13762b(preference, "preference");
        C4147i.m13762b(str, "valueString");
        C4147i.m13762b(str2, "defalutTimeInterval");
        if (!TextUtils.isEmpty(C5503n.m20176b(str).toString())) {
            try {
                if (Integer.parseInt(str) >= Integer.parseInt(str2)) {
                    preference.setSummary(str);
                    return true;
                }
                C3155c.m11196a(getString(R.string.app_setting_sync_time_enter_larger_time_period_tips));
                return false;
            } catch (NumberFormatException unused) {
                C3155c.m11196a(getString(R.string.app_setting_sync_time_input_is_not_legal_tips));
                return false;
            }
        } else {
            C3155c.m11196a(getString(R.string.app_setting_sync_time_interval_cannot_be_empty_tips));
            return false;
        }
    }

    *//* access modifiers changed from: protected *//*
    *//* renamed from: a *//*
    public final boolean mo11103a(String str, String str2) {
        C4147i.m13762b(str, "valueString");
        C4147i.m13762b(str2, "urlTitle");
        if (C3123d.m11111a(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(getString(R.string.app_empty_tips));
            C3155c.m11196a(sb.toString());
            return false;
        } else if (f7579a.mo11106a(str) && C3150b.m11182a(str)) {
            return true;
        } else {
            C3155c.m11196a(getString(R.string.app_tip_illegal_value, new Object[]{str2}));
            return false;
        }
    }

    *//* access modifiers changed from: protected *//*
    *//* renamed from: b *//*
    public final boolean mo11104b(Preference preference, String str, String str2) {
        C4147i.m13762b(preference, "preference");
        C4147i.m13762b(str, "valueString");
        C4147i.m13762b(str2, "urlTitle");
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(getString(R.string.app_empty_tips));
            C3155c.m11196a(sb.toString());
            return false;
        } else if (C3150b.m11182a(str)) {
            preference.setSummary(charSequence);
            return true;
        } else {
            C3155c.m11196a(getString(R.string.app_tip_illegal_value, new Object[]{str2}));
            return false;
        }
    }

    *//* renamed from: a *//*
    public final String mo11101a(int i) {
        String string = getResources().getString(i);
        C4147i.m13757a((Object) string, "resources.getString(resId)");
        return string;
    }*/
}
