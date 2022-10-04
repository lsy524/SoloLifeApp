## 자취생들을 위한 자취생 커뮤니티 앱 
 
### 주요기능 ###
* 회원가입
* 로그인
  * 비회원 로그인 
* 로그아웃 
* 카테고리 
* 웹뷰를 이용한 웹 콘텐츠  
* 게시판 
  * 게시글 작성 
  * 게시글 수정  
  * 게시글 삭제
* 북마크 

## 파일 구조
```bash
├── activities
│   └── MainActivity.kt
│   └── SplashActivity.kt
├── adapter
│   └── BoardListLVAdapter.kt
│   └── BookmarkRVAdapter.kt
│   └── CommentLVAdapter.kt
│   └── ContentRVAdapter.kt
├── auth
│   └── IntroActivity.kt
│   └── JoinActivity.kt
│   └── LoginActivity.kt
├── board
│   └── BoardEditActivity.kt
│   └── BoardInsideActivity.kt
│   └── BoardWriteActivity.kt
├── comment
│   └── CommentModel.kt
├── contentList
│   └── BookmarkModel.kt
│   └── ContentListActivity.kt
│   └── ContentModel.kt
│   └── ContentShowActivity.kt
├── fragments
│   └── BookmarkFragment.kt
│   └── HomeFragment.kt
│   └── StoreFragment.kt
│   └── TalkFragment.kt
│   └── TipFragment.kt
├── model
│   └── BoardModel.kt
├── setting
│   └── SettingActivity.kt
├── util
│   └── FBAuth.kt
│   └── FBRef.kt
```
