<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./include/header.jsp" %>

<!-- 이후 메인 콘텐츠 영역 -->
    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
       <!-- 최근등록한 회원 목록 -->
       <div class="card">
        <div class="card-header">
          <h3 class="card-title">최근등록한 회원</h3>

          <div class="card-tools">
            <!-- <span class="badge badge-danger">8 New Members</span> -->
            <button type="button" class="btn btn-tool" data-card-widget="collapse">
              <i class="fas fa-minus"></i>
            </button>
            <button type="button" class="btn btn-tool" data-card-widget="remove">
              <i class="fas fa-times"></i>
            </button>
          </div>
        </div>
        <!-- /.card-header -->
        <div class="card-body p-0">
          <ul class="users-list clearfix">
            <li style="cursor: pointer;" onclick="alert('해당회원정보로 이동합니다. -준비중')">
              <img src="resources/admin/dist/img/default-150x150.png" alt="User Image">
              <a class="users-list-name" href="#">관리자</a>
              <span class="users-list-date">2021-05-28</span>
            </li>
            <li>
              
            </li>
          </ul>
          <!-- /.users-list -->
        </div>
        <!-- /.card-body -->
        <div class="card-footer text-center">
          <a href="javascript('회원목옥으로 이동-준비중')">View All Users</a>
        </div>
        <!-- /.card-footer -->
      </div>
       <!-- //최근등록한 회원목록 -->
      <!-- 최근 게시물 리스트 (공지사항+갤러리+QnA게시판) -->
      <div class="card">
        <div class="card-header border-transparent">
          <h3 class="card-title">최근 공지사항</h3>

          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-card-widget="collapse">
              <i class="fas fa-minus"></i>
            </button>
            <button type="button" class="btn btn-tool" data-card-widget="remove">
              <i class="fas fa-times"></i>
            </button>
          </div>
        </div>
        <!-- /.card-header -->
        <div class="card-body p-0">
          <div class="table-responsive">
            <table class="table m-0">
              <thead>
              <tr>
                <th>Order ID</th>
                <th>Item</th>
                <th>Status</th>
                <th>Popularity</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td><a href="pages/examples/invoice.html">OR9842</a></td>
                <td>Call of Duty IV</td>
                <td><span class="badge badge-success">Shipped</span></td>
                <td>
                  <div class="sparkbar" data-color="#00a65a" data-height="20">90,80,90,-70,61,-83,63</div>
                </td>
              </tr>
             </tbody>
            </table>
          </div>
          <!-- /.table-responsive -->
        </div>
        <!-- /.card-body -->
        <div class="card-footer clearfix">
          <a href="javascript:void(0)" class="btn btn-sm btn-info float-right">더보기</a>
        </div>
        <!-- /.card-footer -->
      </div>
      <div class="card">
        <div class="card-header border-transparent">
          <h3 class="card-title">최근 겔러리</h3>

          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-card-widget="collapse">
              <i class="fas fa-minus"></i>
            </button>
            <button type="button" class="btn btn-tool" data-card-widget="remove">
              <i class="fas fa-times"></i>
            </button>
          </div>
        </div>
        <!-- /.card-header -->
        <div class="card-body p-0">
          <div class="table-responsive">
            <table class="table m-0">
              <thead>
              <tr>
                <th>Order ID</th>
                <th>Item</th>
                <th>Status</th>
                <th>Popularity</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td><a href="pages/examples/invoice.html">OR9842</a></td>
                <td>Call of Duty IV</td>
                <td><span class="badge badge-success">Shipped</span></td>
                <td>
                  <div class="sparkbar" data-color="#00a65a" data-height="20">90,80,90,-70,61,-83,63</div>
                </td>
              </tr>
             </tbody>
            </table>
          </div>
          <!-- /.table-responsive -->
        </div>
        <!-- /.card-body -->
        <div class="card-footer clearfix">
          <a href="javascript:void(0)" class="btn btn-sm btn-info float-right">더보기</a>
        </div>
        <!-- /.card-footer -->
      </div>
      <!-- //최근 게시물 리스트 -->


      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
<!-- 여기까지 메인 콘텐츠 영역 -->

<%@ include file="./include/footer.jsp" %>    