package wizard

import groovy.beans.Bindable
import groovy.transform.Synchronized

class WizardModel {
    @Bindable boolean backEnabled
    
    private int currentPage = 0i
    private int totalPages = 0i
    
    @Synchronized
    void setTotalPages(int n) { totalPages = n }
    @Synchronized
    int getTotalPages() { totalPages }
    
    @Synchronized
    boolean decrease() {
        int nextPage = currentPage - 1
        if(nextPage >= 0) {
            currentPage = nextPage
        }
        setBackEnabled(currentPage != 0)
        nextPage == currentPage
    }
    
    @Synchronized
    boolean increase() {
        int nextPage = currentPage + 1
        if(nextPage < totalPages) {
            currentPage = nextPage
        }
        setBackEnabled(currentPage != 0)
        nextPage == currentPage
    }
}