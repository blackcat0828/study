
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Core Scripts - Include with every page -->
    <script src="/resources/js/jquery-1.10.2.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>

    <!-- Page-Level Plugin Scripts - Tables -->
    <script src="/resources/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="/resources/js/plugins/dataTables/dataTables.bootstrap.js"></script>

    <!-- SB Admin Scripts - Include with every page -->
    <script src="/resources/js/sb-admin.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').dataTable({
        	//반응형으로 동작을 하겠다는 선언
        	responsive:true;
        });
        
        //왼쪽 메뉴바 속성을 지정
        $(".sidebar-nav")
        	//부트스트랩 네비게이션바 자동 접기 옵션
        	.attr("class","sidebar-nav navbar-collapse collapse")
        	//모바일 크기에서 새로고침 클릭시 자동으로 메뉴가 펼쳐지는 문제를 해결
        	.attr("aria-expanded","false")
        	.attr("style","height:1px")
        	
    });
    
    
    </script>

</body>

</html>
    