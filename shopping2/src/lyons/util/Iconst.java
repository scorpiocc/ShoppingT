package lyons.util;

/**
 * 
 *���õĹ�������
 * @author  lyons(zhanglei)
 */
public interface Iconst
{
    
   /**
    * Goods�����������ѯ�����ؽ��Ϊ��
    */
   public static final String QUERY_ALLGOODS_BY_CONDITION_RETURN_NULL = "<br><br><br><center> " +
   		                                                 "<font color=green> �͹�,��ѯ�޴���Ʒ��.�����ؼ����ٴ�" +
   		                                                 " </font> <a href=/Adapter/jsp/browse/searchByKeyWord.jsp>" +
   		                                                 "<font color=red size=6>��ѯ</font></a></center>";
   /**
    * Goods�����ݿ������κ���Ϣ
    */
   public static final String QUERY_ALLGOODS_RETURN_NULL =  "<br><br><br><center>" +
                                                       		"<font color=green> ��,���һ�û�ϻ��� </font>" +
                                                       		"<a href=/Adapter/Goods.action?key=4>" +
                                                       		"<font color=red size=6>������ҳ</font></a></center>";
   
  /**
   * Goods������Ʒ�ɹ�
   * ��Ҫ�����ַ���һ��ʹ��
   */
   public static final String buy_goods_success_1 = "<br><br><br><center><font size=5 color=red><B>";
   public static final String buy_goods_success_2 ="</font>&nbsp;<br><br><br>" +
                                               		"<a href=/Adaqpter/Goods.action?key=4>���ؼ�������</a>" +
                                               		"&nbsp;or&nbsp;" +
                                               		"<a href=/Adapter/Order.action?key=1>�鿴�ҵĶ���</a></center>";
   		
   
}
