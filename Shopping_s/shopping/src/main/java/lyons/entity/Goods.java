package lyons.entity;


import com.sun.rowset.CachedRowSetImpl;

/**
 * ��Ʒʵ����
 * @author lyons(zhanglei)
 *
 */
public class Goods
{

	CachedRowSetImpl rowSet = null; //�������е��м�����

	private int pageSize = 5;	//ÿҳ��ʾ��������¼(Ĭ��Ϊ5��)
	private int currentPage = 1;//��ǰҳ��
	private int totalRecord = 1;//�ܼ�¼��
	private int totalPage = 1;	 //��ҳ��
	
	public Goods(){}

	public Goods(CachedRowSetImpl rowSet, int pageSize, int currentPage,
			int totalPRecord, int totalPage)
	{
		this.rowSet = rowSet;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalPRecord;
		this.totalPage = totalPage;
	}

    public CachedRowSetImpl getRowSet()
    {
        return rowSet;
    }

    public void setRowSet(CachedRowSetImpl rowSet)
    {
        this.rowSet = rowSet;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public int getTotalRecord()
    {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord)
    {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }


}
