package com.xyj.strokeaid.view.editspinner;

/**
 * EditSpinnerFilter
 *
 * @author WrBug
 * @since 2017/2/25
 */
public interface EditSpinnerFilter {
    /**
     * editText输入监听
     * @param keyword
     * @return
     */
   public boolean onFilter(String keyword);
}
